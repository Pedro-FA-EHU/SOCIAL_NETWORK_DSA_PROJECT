package packProject;

public class Person {

	// id should be unique for each person. Careful with the possible exception.
	private String id;
	private String name;
	private String lastname;
	private String birthdate;
	private String gender;
	private String birthplace;
	private String home;
	private String[] studiedat;
	private String[] workplaces;
	private String[] films;
	private String[] friendships;
	// groupcode is it constant? Maybe we use other people data, from other groups.
	private String groupcode= "G612498";
	
	
	// Se deben tratar las excepciones si los datos introducidos no son correctos aqui :
	// Ejemplo --> birthdate = "4545-545-55" no es correcto.
	// Otra cuestion a tratar es si el usuario no trabaja por ejemplo. Atributos en esencia vacios.
	// Id son únicos, se debe verificar primeramente.
	
	public Person(String pId,String pName,String pLastName,String pBirthDate,String pGender,String pBirthPlace, String pHome, String[] pStudieDat, String[] pWorkPlaces, String[] pFilms, String pGroupcode) {

		try {
		id=pId;
		name=pName;
		lastname=pLastName;
		birthdate=pBirthDate;
		gender=pGender;
		birthplace=pBirthPlace;
		home=pHome;
		studiedat=pStudieDat;
		workplaces=pWorkPlaces;
		films=pFilms;
		groupcode=pGroupcode;
		}
		catch() {
			
		}
	}
	
	// Getters and Setters can be implemented depending on the Social Network posibilities. Maybe we want to know only someone id.
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		
		String StudieDat = new String();
		String WorkPlaces = new String();
		String Films = new String();
		String Friendships = new String();
		
		//Array to String Transformation of studiedat

		for (int i=0;i<this.studiedat.length;i++) {
			StudieDat+=this.studiedat[i]+",";
		}
		// Replacing last character of the String, "," --> ";" 
		StudieDat=StudieDat.substring(0,StudieDat.length()-1)+";";
		
		for (int i=0;i<this.films.length;i++) {
			Films+=this.films[i]+",";
		}
		Films=Films.substring(0,Films.length()-1)+";";
		
		for (int i=0;i<this.workplaces.length;i++) {
			WorkPlaces+=this.workplaces[i]+",";
		}
		WorkPlaces=WorkPlaces.substring(0,WorkPlaces.length()-1)+";";
		
		for (int i=0;i<this.friendships.length;i++) {
			Friendships+=this.friendships[i]+",";
		}
		Friendships=Friendships.substring(0,Friendships.length()-1)+";";
		
		return this.id+" "+this.name+","+this.lastname+","+this.birthdate+","+this.gender+","+this.birthplace+","+this.home+","+StudieDat+WorkPlaces+Films+Friendships+this.groupcode;
		

	}
		
}
