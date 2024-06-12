package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;


public class DeleteCandBean {

	private int id;
	private String message;
	
	public DeleteCandBean() {
		super();
	}
	public int getId() {
		return id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void deleteCandidate() {
		try(CandidateDao candDao = new CandidateDaoImpl()){
			int count=candDao.deleteById(id);
			if(count==1)
			{
				this.message="Candidate deleted successfully = "+count;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
