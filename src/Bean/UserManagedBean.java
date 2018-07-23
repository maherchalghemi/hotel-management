package Bean;



import Model.Hotel;
import Model.RoleUsers;
import Model.Users;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import Service.IRoleUsersService;
import Service.IUsersService;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static java.util.jar.Pack200.Packer.ERROR;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;


@ManagedBean(name="userMB")
@SessionScoped
public class UserManagedBean implements Serializable{
	
	 private static final long serialVersionUID = 1L;
	    private static final String SUCCESS = "success";
	    private static final String ERROR = "error";
	 @ManagedProperty(value = "#{UsersService}")
	    IUsersService usersService;
	 @ManagedProperty(value="#{RoleUsersService}")
		IRoleUsersService roleUsersService;
	private String name = "";
	private Users users;
	private Users usersNew;
	private List<Users> usersList;
	private String day;
    private String month;
    private String year;
	
	public  UserManagedBean() {
		Users users = new Users();
		
	}
	
	
	 public String addUsers() throws ParseException {
	        try {
	            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	            String dateInString = day + "/" + month + "/" + year;
	            
	            Date date = formatter.parse(dateInString);
	            users.setDateNaissance(date);
	            users.setEnable(1);
	            
	            getUsersService().addUsers(users);
	            
	            RoleUsers roleUsers= new RoleUsers();
	            roleUsers.setRole("ROLE_ADMIN");
	            roleUsers.setUsers(users);
	            getRoleUsersService().addRoleUsers(roleUsers);
	            
	            return SUCCESS;
	        } catch (DataAccessException e) {
	            e.printStackTrace();
	        }
			return ERROR;
			}
	
	 public String updUsers() {
	        try {
	            getUsersService().updateUsers(users);;
	            return SUCCESS;
	        } catch (DataAccessException e) {
	            e.printStackTrace();
	        }

	        return ERROR;
	    }
	
	public void getLogin(){
		if(name.equals("")){
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			  
			name  = user.getUsername(); 
			users=getUsersService().getUsersByLogin(name);
			name="";
		}
	

	}



/**
 * Get Users Service
 *
 * @return IUsesService - Users Service
 */
public IUsersService getUsersService() {
    return usersService;
}

/**
 * Set Users Service
 *
 * @param IUsersService - Users Service
 */
public void setUsersService(IUsersService usersService) {
    this.usersService = usersService;
}

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Users getUsers() {
		return users;
	}



	public void setUsers(Users users) {
		this.users = users;
	}
	   public List<Users> getUsersList() {
	    	usersList = new ArrayList<Users>();
	    	usersList.addAll(getUsersService().getUsers());
	    	
	        
	        return usersList;
	    }
	    
	   public IRoleUsersService getRoleUsersService() {
	        return roleUsersService;
	    }

	    public void setRoleUsersService(IRoleUsersService roleUsersService) {
	        this.roleUsersService = roleUsersService;
	    }
	    
	    
	    /**
	     * Set Hotel List
	     *
	     * @param List - Hotel List
	     */
	    public void setUsersList(List<Users> usersList) {
	        this.usersList = usersList;
	    }
	    
	    

		 public String getDay() {
       return day;
   }

   public void setDay(String day) {
       this.day = day;
   }

   public String getMonth() {
       return month;
   }

   public void setMonth(String month) {
       this.month = month;
   }

   public String getYear() {
       return year;
   }

   public void setYear(String year) {
       this.year = year;
   }


public Users getUsersNew() {
	return usersNew;
}


public void setUsersNew(Users usersNew) {
	this.usersNew = usersNew;
}




	
}
