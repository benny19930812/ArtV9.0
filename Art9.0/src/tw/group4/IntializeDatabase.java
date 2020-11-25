package tw.group4;

import tw.group4._14_.init.APTableReset;
import tw.group4._35_.init.model.CreateTableInsertDataService;

public class IntializeDatabase {
	
	public static void main(String[] args) {
		
//		全部執行完畢需時30-60秒
//		new CreateTableInsertDataService().execute35();
		new APTableReset().execute14();
	}
}
