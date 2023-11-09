package entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Role {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idRole;
    private String Name;
    
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Role(String name) {
		super();
		Name = name;
	}


	@ManyToMany
	@JoinTable(name = "user_role",
				joinColumns = @JoinColumn (name = "idRole"),
				inverseJoinColumns = @JoinColumn(name = "idUser"))
	private List<User> users = new ArrayList<>();

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", Name=" + Name + ", users=" + users + "]";
	}
	
	

}
