package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class VoteBean {

	private int userId;
	private int candidId;
	private int count;
	public VoteBean() {
		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCandidId() {
		return candidId;
	}
	public void setCandidId(int candidId) {
		this.candidId = candidId;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void candVote() {
		try(CandidateDao candDao = new CandidateDaoImpl();UserDao userdao=new UserDaoImpl()){
			count = candDao.incrementVote(candidId);
			if(count == 1) {
				userdao.updateStatus(userId, true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
