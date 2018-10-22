package com.Java.dbo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Java.model.FresherCandidate;
import com.Java.sqlserver.DBConnection;



public class FresherCandidateDAO implements IDAO<FresherCandidate>{

        @Override
        public FresherCandidate addNew(FresherCandidate fresherCandidate) {
            if(fresherCandidate != null) {
                Connection cnn = DBConnection.openConnection();
                PreparedStatement ps = null;
                if(cnn!=null) {
                    try {
                        String sql = "INSERT INTO Candidate(FirstName,LastName,BirthDate,Address,Phone,Email,Candidate_type,Graduation_date,Graduation_rank,Education)"
                                + " VALUES(?,?,?,?,?,?,?,?,?,?)";
                        ps = cnn.prepareStatement(sql);
                        ps.setString(1, fresherCandidate.getFirstName());
                        ps.setString(2, fresherCandidate.getLastName());
                        ps.setInt(3, fresherCandidate.getBirthDate());
                        ps.setString(4, fresherCandidate.getAddress());
                        ps.setString(5, fresherCandidate.getPhone());
                        ps.setString(6, fresherCandidate.getEmail());
                        ps.setInt(7, 1);
                        ps.setString(8, fresherCandidate.getGraduationDate());
                        ps.setString(9, fresherCandidate.getGraduationRank());
                        ps.setString(10, fresherCandidate.getEducation());
                        int executeUpdate = ps.executeUpdate();
                        if(executeUpdate > 0) {
                            return fresherCandidate;
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
        public List<FresherCandidate> getAll() {
            List<FresherCandidate> list = null;
            Connection cnn = DBConnection.openConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            if(cnn!=null) {
                try {
                    String sql = "SELECT FirstName, LastName, BirthDate, Address, Phone, Email, Candidate_type,Graduation_date, Graduation_rank ,Education FROM Candidate";
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
                        String graduationDate = rs.getString("Graduation_date");
                        String graduationRank = rs.getString("Graduation_rank");
                        String education = rs.getString("Education");
                        FresherCandidate fresherCandidate = new FresherCandidate(firstName, lastName, birthDate, address, phone, email, candidateType, graduationDate, graduationRank, education);
                        list.add(fresherCandidate);
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
