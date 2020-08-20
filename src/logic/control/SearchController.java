package logic.control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logic.bean.SearchBean;
import logic.dao.LibraryDao;
import logic.entity.Library;

public class SearchController {
	List<Library> libraries;
	LibraryDao libraryDao;
	
	SearchBean searchBean;	//BEAN
	
	public SearchController() {
		this.libraries = new ArrayList<>();
		this.libraryDao = new LibraryDao();
		this.searchBean = new SearchBean();
	}
	
	public SearchController(SearchBean searchBean) {
		// TODO Auto-generated constructor stub
		this.libraries = new ArrayList<>();
		this.libraryDao = new LibraryDao();
		this.searchBean = searchBean;
	}
	
	/*
	 * cerca librerie da db 
	 */
	public void searchLibraryFromCity(String location) {
		try {
			libraries = libraryDao.select(location.toLowerCase(), null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setSearchBean(libraries);
	}
	
	/*
	 * setta la bean di risposta alla ricerca librerie da db
	 */
	public void setSearchBean(List<Library> results) {
		searchBean.setResultLibraries(results);
	}
	
	public List<Library> getResultsSearchBean() {
		return searchBean.getResultLibraries();
	}

	public void getInfoLibrary(Library library) {
		// TODO Auto-generated method stub
		
	}

	public SearchBean getSearchBean() {
		// TODO Auto-generated method stub
		return searchBean;
	}
	
}
