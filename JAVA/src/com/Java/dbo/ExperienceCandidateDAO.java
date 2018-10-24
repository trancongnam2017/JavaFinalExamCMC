package com.Java.dbo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Java.model.ExperienceCandidate;
import com.Java.sqlserver.DBConnection;



public class ExperienceCandidateDAO implements DAOInterface<ExperienceCandidate> {

        @Override
        public ExperienceCandidate addNew(ExperienceCandidate experienceCandidate) {
            if(experienceCandidate != null) {
                Connection cnn = DBConnection.openConnection();
                PreparedStatement ps = null;
                if(cnn!=null) {
                    try {
                        String sql = "INSERT INTO Candidate(FirstName,LastName,BirthDate,Address,Phone,Email,Candidate_type,ExpInYear,ProSkill)"
                                + " VALUES(?,?,?,?,?,?,?,?,?)";
                        ps = cnn.prepareStatement(sql);
                        ps.setString(1, experienceCandidate.getFirstName());
                        ps.setString(2, experienceCandidate.getLastName());
                        ps.setInt(3, experienceCandidate.getBirthDate());
                        ps.setString(4, experienceCandidate.getAddress());
                        ps.setString(5, experienceCandidate.getPhone());
                        ps.setString(6, experienceCandidate.getEmail());
                        ps.setInt(7, 0);
                        ps.setInt(8, experienceCandidate.getExpInYear());
                        ps.setString(9, experienceCandidate.getProSkill());
                        int executeUpdate = ps.executeUpdate();
                        if(executeUpdate > 0) {
                            return experienceCandidate;
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
        public List<ExperienceCandidate> getAll() {
            List<ExperienceCandidate> list = null;
            Connection cnn = DBConnection.openConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            if(cnn!=null) {
                try {
                    String sql = "SELECT FirstName, LastName, BirthDate, Address, Phone, Email, Candidate_type, ExpInYear, ProSkill FROM Candidate";
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
                        int expInYear = rs.getInt("ExpInYear");
                        String proSkill = rs.getString("ProSkill");
                        ExperienceCandidate experienceCandidate = new ExperienceCandidate(firstName, lastName, birthDate, address, phone, email, candidateType, expInYear, proSkill);
                        list.add(experienceCandidate);
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

