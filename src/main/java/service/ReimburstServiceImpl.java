package service;

import java.util.List;

import dao.ReimburstDao;
import dao.ReimburstDaoImpl;
import exception.ApplicationException;
import pojo.ReimburstPojo;

public class ReimburstServiceImpl implements ReimburstService {



	ReimburstDao reimburstDao;
	
	public ReimburstServiceImpl() {
		this.reimburstDao = new ReimburstDaoImpl();
	}

	@Override
	public ReimburstPojo addReimburst(ReimburstPojo reimburstPojo) throws ApplicationException {
		
		return this.reimburstDao.addReimburst(reimburstPojo);
	}


	@Override
	public List<ReimburstPojo> getAllReimburstments() throws ApplicationException {
		List<ReimburstPojo> allReimburstment = this.reimburstDao.getAllReimburstments();
		return allReimburstment;
	}

	
	@Override
	public List<ReimburstPojo> getUserReimburstments(int userId) throws ApplicationException {
		return this.reimburstDao.getUserReimburstments(userId);
	}
	@Override
	public void exitApplication() {
		
	}

	@Override
	public List<ReimburstPojo> getUserResolvedReimburstments(int userId) throws ApplicationException {
		return this.reimburstDao.getUserResolvedReimburstments(userId);
	}

	@Override
	public List<ReimburstPojo> getUserPendingReimburstments(int userId) throws ApplicationException {
		 return this.reimburstDao.getUserPendingReimburstments(userId);
	}

	@Override
	public List<ReimburstPojo> getResolvedReimburstments() throws ApplicationException {
		return this.reimburstDao.getResolvedReimburstments();
	}

	@Override
	public List<ReimburstPojo> getPendingReimburstments() throws ApplicationException {
		return this.reimburstDao.getPendingReimburstments();
	}



	@Override
	public ReimburstPojo getAReimburst(int reimburstId) throws ApplicationException {
		return this.reimburstDao.getAReimburst(reimburstId);
	}

	@Override
	public ReimburstPojo updateReimburst(ReimburstPojo reimburst) throws ApplicationException {
		return this.reimburstDao.updateReimburst(reimburst);
	}

}
