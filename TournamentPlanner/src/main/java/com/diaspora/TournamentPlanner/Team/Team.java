package com.diaspora.TournamentPlanner.Team;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer teamId;
	
	public String name;
	public String memberNames;
	
	@Column(updatable = false)
	public Date createdDate;
		
	public Date lastModifiedDate;
	

	public Team() {
		super();
	}
	
	
	
	public Team(Integer teamId, String name, String memberNames, Date createdDate, Date lastModifiedDate) {
		super();
		this.teamId = teamId;
		this.name = name;
		this.memberNames = memberNames;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
    @PrePersist
    public void onPrePersist() {
        setCreatedDate(new Date());
        setLastModifiedDate(new Date());
    }
      
    @PreUpdate
    public void onPreUpdate() {
    	setLastModifiedDate(new Date());
    }	
    
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = Integer.parseInt(teamId);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + "]";
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getMemberNames() {
		return memberNames;
	}

	public void setMemberNames(String memberNames) {
		this.memberNames = memberNames;
	}
	
	
	
}
