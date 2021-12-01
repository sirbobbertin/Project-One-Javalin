package service;

import java.util.List;

import exception.ApplicationException;
import pojo.ReimburstPojo;

public interface ReimburstService {
	ReimburstPojo addReimburst(ReimburstPojo reimburstPojo) throws ApplicationException;
	List<ReimburstPojo> getAllReimburstments() throws ApplicationException;
	List<ReimburstPojo> getResolvedReimburstments() throws ApplicationException;
	List<ReimburstPojo> getPendingReimburstments() throws ApplicationException;
	ReimburstPojo getAReimburst(int reimburstId) throws ApplicationException;
	ReimburstPojo updateReimburst(ReimburstPojo reimburst) throws ApplicationException;
	List<ReimburstPojo> getUserReimburstments(int userId) throws ApplicationException;
	List<ReimburstPojo> getUserResolvedReimburstments(int userId) throws ApplicationException;
	List<ReimburstPojo> getUserPendingReimburstments(int userId) throws ApplicationException;
	void exitApplication();
}
