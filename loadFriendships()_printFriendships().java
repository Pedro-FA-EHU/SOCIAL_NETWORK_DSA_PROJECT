public static void insertDoubleFriendship(String[] friendships) throws UnregisteredIDException {
		
		int i=0;
		boolean friendFound1=false;
		boolean friendFound2=false;
		try {
		while(!friendFound1) {
			if(userList.getElement(i).getId().equals(friendships[0])) {
				friendFound1=true;
				if(userList.getElement(i).getFriendships().equals("")) {
					userList.getElement(i).setFriendships(friendships[1]);
				}
				else {
					userList.getElement(i).setFriendships(userList.getElement(i).getFriendships()+","+friendships[1]);
				}
				
			}
			else {
				i++;
			}
		}
		i=0;
		while(!friendFound2 && i<userList.size()) {
			if(userList.getElement(i).getId().equals(friendships[1])) {
				friendFound2=true;
				if(userList.getElement(i).getFriendships().equals("")) {
					userList.getElement(i).setFriendships(friendships[0]);
				}
				else {
					userList.getElement(i).setFriendships(userList.getElement(i).getFriendships()+","+friendships[0]);
				}
				
			}
			else {
				i++;
			}
		}
		}
		catch(EmptyCollectionException e) {
			System.out.println(e.getMessage());
		}
		catch(AccessOutOfBoundariesException e) {
			System.out.println(e.getMessage());
		}
		
		if(!friendFound2 && i==userList.size()) {
			throw new UnregisteredIDException();
		}
		
	}
	
	// Problema de tener amigos repetidos, ahora lo trato
	
	public static void loadFriend (String f) throws UnregisteredIDException {
		String[] friendships=f.split(",");
		boolean friendFound=false;
		int i=0;
		// Obviamente estoy considerando que friendships.txt estan los usuarios correspondientes --> TRATAMIENTO DE EXCEPCION
		while(!friendFound && i<userList.size()) {
			try {
			if(userList.getElement(i).getId().equals(friendships[0])) {
				friendFound=true;
				insertDoubleFriendship(friendships);
			}
			else {
				i++;
	
			}
			}
			catch(EmptyCollectionException e) {
				System.out.println(e.getMessage());
			}
			catch(AccessOutOfBoundariesException e) {
				System.out.println(e.getMessage());
			}
			catch(UnregisteredIDException e) {
				System.out.println(e.getMessage());
			}
		}
		
		if(i==userList.size() && !friendFound) {
			throw new UnregisteredIDException();
		}
	}
	
	
	
	public static void loadFriendships() {
		
	    // We will in the future let the admin choose his own pathfile
		String myPath = "C:\\Users\\sergi\\Downloads\\DataFriendships.txt";
			try{
				File myFilename = new File(myPath);
				Scanner input2Program = new Scanner (myFilename);
				String oneFriendship=input2Program.nextLine();
				while ( input2Program.hasNext() ){		
					oneFriendship = input2Program.nextLine();
					loadFriend(oneFriendship);
					
				}
			} catch (FileNotFoundException e) {
					 e.printStackTrace();
					 System.out.println("Error, file not found");
			}
			catch(UnregisteredIDException e) {
				System.out.println(e.getMessage());
			}
	
	}

	public static void printFriendships() {
		try {
		for(int i=0;i<userList.size();i++) {
			System.out.println(userList.getElement(i).getFriendships());
		}
		}
		catch(EmptyCollectionException e) {
			System.out.println(e.getMessage());
		}
		catch(AccessOutOfBoundariesException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
