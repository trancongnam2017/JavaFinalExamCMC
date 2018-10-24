package com.Java.dbo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Java.model.InternCandidate;
import com.Java.sqlserver.DBConnection;



public class InternCandidateDAO implements DAOInterface<InternCandidate> {

        @Override
        public InternCandidate addNew(InternCandidate internCandidate) {
            if(internCandidate != null) {
                Connection cnn = DBConnection.openConnection();
                PreparedStatement ps = null;
                if(cnn!=null) {
                    try {
                        String sql = "INSERT INTO Candidate(FirstName,LastName,BirthDate,Address,Phone,Email,Candidate_type,majors,semester,University_name)"
                                + " VALUES(?,?,?,?,?,?,?,?,?,?)";
                        ps = cnn.prepareStatement(sql);
                        ps.setString(1, internCandidate.getFirstName());
                        ps.setString(2, internCandidate.getLastName());
                        ps.setInt(3, internCandidate.getBirthDate());
                        ps.setString(4, internCandidate.getAddress());
                        ps.setString(5, internCandidate.getPhone());
                        ps.setString(6, internCandidate.getEmail());
                        ps.setInt(7, 2);
                        ps.setString(8, internCandidate.getMajors());
                        ps.setString(9, internCandidate.getSemester());
                        ps.setString(10, internCandidate.getUniversityName());
                        int executeUpdate = ps.executeUpdate();
                        if(executeUpdate > 0) {
                            return internCandidate;
                        }
                        return null;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        DBConnection.closeConnection(cnn, ps, null, null);
                    }   
                }
            }
            return null;
        }

        @Override
        public List<InternCandidate> getAll() {
            List<InternCandidate> list = null;
            Connection cnn = DBConnection.openConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            if(cnn!=null) {
                try {
                    String sql = "SELECT FirstName, LastName, BirthDate, Address, Phone, Email, Majors,Semester, University_name ,Education FROM Candidate";
                    ps = cnn.prepareStatement(sql);
                    rs = ps.executeQuery();
                    list = new ArrayList<>();
                    while (rs.next()) {
                        String firstName = rs.getString("FirstName");
                        String lastName = rs.getString("LastName");
                        int birthDate = rs.getInt("BirthDate");
                        String address = rs.getString("Address");
                        String phone = rs.getString("Phone");
                        String email = rs.getString("Email");
                        int candidateType = rs.getInt("Candidate_type");
                        String majors = rs.getString("Majors");
                        String semester = rs.getString("Semester");
                        String universityName = rs.getString("University_name");
                        InternCandidate internCandidate = new InternCandidate(firstName, lastName, birthDate, address, phone, email, candidateType, majors, semester, universityName);
                        list.add(internCandidate);
                    }
                    return list;
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    DBConnection.closeConnection(cnn, ps, rs, null);
                }

            }
            return null;
        }
        
    }