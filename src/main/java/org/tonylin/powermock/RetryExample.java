package org.tonylin.powermock;

public class RetryExample {
	public User readUser(){
		int attempt = 0;
		int maxAttempt = 2;
		boolean retry = false;
		User user = null;
		do {
			try {
				retry = false;
				if (attempt == 0)
					user = DaoUtil.readUserFromDB();
				else
					user = DaoUtil.readUserFromFile();
			} catch (Exception e) {
				attempt++;
				retry = true;
				if (attempt > maxAttempt)
					throw new RuntimeException(e);
			}
		} while (attempt <= maxAttempt && retry);
		return user;
	}
}
