// Retrieve all the cliques with exactly 4 users.
	    	
	    	LinkedList<LinkedList<String>> possibleClique4user = new LinkedList<>();
	        LinkedList<String> clique4user = new LinkedList<String>();
	    	
          try {
	    		
	    		
	    	    // Every possible 4 cliques user added
	    	    for (int i = 0; i < usersList.size(); i++) {
	    	        for (int j = i + 1; j < usersList.size(); j++) {
	    	            if (friendships.adj()[i][j]) {
	    	                for (int k = j + 1; k < usersList.size(); k++) {
	    	                    if (friendships.adj()[i][k] && friendships.adj()[j][k]) {
	    	                        for (int w = k + 1; w < usersList.size(); w++) {
	    	                            if (friendships.adj()[i][w] && friendships.adj()[j][w] && friendships.adj()[k][w]) {
	    	                                clique4user.insert(usersList.getElement(i).getId(), clique4user.size());
	    	                                clique4user.insert(usersList.getElement(j).getId(), clique4user.size());
	    	                                clique4user.insert(usersList.getElement(k).getId(), clique4user.size());
	    	                                clique4user.insert(usersList.getElement(w).getId(), clique4user.size());

	    	                                
	    	                                clique4user=new LinkedList<String>();
	    	                            }
	    	                        }
	    	                    }
	    	                }
	    	            }
	    	        }
	    	    }

	    	    // Print Cliques of 4 users.
	    	    System.out.println("------------------------------------------------------------");
	    	    for (int i = 0; i < possibleClique4user.size(); i++) {
	    	        System.out.print("Clique #" + i + " :");
	    	        for (int j = 0; j < 4; j++) {
	    	            System.out.print(" " + possibleClique4user.getElement(i).getElement(j) + " ");
	    	        }
	    	        System.out.println("\n------------------------------------------------------------");
	    	    }

	    	} catch (EmptyCollectionEx e) {
	    	    System.out.println(e.getMessage());
	    	}
