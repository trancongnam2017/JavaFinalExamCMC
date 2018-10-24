package com.Java.business;

import java.util.ArrayList;
import java.util.List;

import com.Java.dbo.DAOInterface;
import com.Java.dbo.InternCandidateDAO;
import com.Java.model.InternCandidate;



public class InternCandidateBUS implements BusinessInterface<InternCandidate> {
        DAOInterface<InternCandidate> internCandidateDAO;
        @Override
        public InternCandidate addNew(InternCandidate internCandidate) {
            internCandidateDAO =  new InternCandidateDAO();
            return internCandidateDAO.addNew(internCandidate);
        }

        @Override
        public List<InternCandidate> getAll() {
            List<InternCandidate> list = new ArrayList<>();
            internCandidateDAO =  new InternCandidateDAO();
            list = internCandidateDAO.getAll();
            return list;
        }
        
        public static void enterInternCandidate() {
            InternCandidate internCandidate = new InternCandidate();
            internCandidate.enterCandidate();
            
            InternCandidateBUS internCandidateBUS = new InternCandidateBUS();
            internCandidateBUS.addNew(internCandidate);
        }
        
        public static void showInternCandidate() {
            List<InternCandidate> list = new ArrayList<>();
            InternCandidateBUS internCandidateBUS = new InternCandidateBUS();
            list = internCandidateBUS.getAll();
            for (InternCandidate internCandidate : list) {
                internCandidate.showCandidate();
            }
        }
    }

