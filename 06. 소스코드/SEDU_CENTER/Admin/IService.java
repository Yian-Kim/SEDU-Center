package Admin;
import java.util.ArrayList;

import DTO_admin.DTO;

public interface IService {

	void add();
	
	ArrayList<DTO> list();

	void edit();

	void del();

	void detail(String sel);

}
