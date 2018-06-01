package ca.eve.app.tiger.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tiger_club_session")
public class Session {

	@Id
	@GeneratedValue
	Long id;

	@Temporal(TemporalType.TIMESTAMP)
	Date startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date endDate;
	
	@ManyToOne(fetch=FetchType.LAZY)    
    public Season season;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}
	
	
}