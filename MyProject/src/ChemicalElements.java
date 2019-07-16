class ChemicalElements {
	private String symbolicName;
	private String fullName;
	private int atomicNumber;

	static int alkaliMetals[] = {3, 11, 19, 37, 55, 87};
	static boolean isAlkali[] = new boolean[100];
	static int metals[] = { 13, 49, 50, 81, 82, 83, 113, 114, 115, 116};
	
	ChemicalElements( int atomicNumber, String symbolicName, String fullName){
		this.symbolicName = symbolicName;
		this.fullName = fullName;
		this.atomicNumber = atomicNumber;
	}
	
	static {
		
		for(int i=0;i<alkaliMetals.length;i++)
			isAlkali[alkaliMetals[i]] = true;
		
	}
	
	int getAtomicNumber() {
		return this.atomicNumber;
	}
	
	String getSymbolicName() {
		return this.symbolicName;
	}
	
	String getFullName() {
		return this.fullName;
	}
	
	void setAtomicNumber(int atomicNumber) {
		this.atomicNumber = atomicNumber;
	}
	
	void setSymbolicName( String symbolicName) {
		this.symbolicName = symbolicName; 
	}
	
	void setFullName( String fullName) {
		this.fullName = fullName;
	}
	
	boolean isAlkaliMetal() {
		if(isAlkali[this.atomicNumber])
			return true;
		return false;
	}
	
	boolean isTransitionMetal() {
		if((this.atomicNumber <= 31 && this.atomicNumber >= 21)
	    ||(this.atomicNumber >= 39 && this.atomicNumber <= 48)
		||(this.atomicNumber >= 72 && this.atomicNumber <= 80)
		||(this.atomicNumber >= 104 && this.atomicNumber <= 112))
			return true;
		return false;
	}
	
	boolean isMetal() {
		//13, 49, 50, 81, 82, 83, 113, 114, 115, 116
		switch(this.atomicNumber) {
		case 13:
		case 49:
		case 50:
	    case 81:
	    case 82:
	    case 83:
	    case 113:
	    case 114:
	    case 115:
	    case 116: return true;
				
		}
		return false;
	}
	
	public boolean equals(Object o) {
		ChemicalElements ch = (ChemicalElements) o;
		if(this.atomicNumber == ch.atomicNumber && this.symbolicName.equals(ch.symbolicName) && this.fullName.equals(ch.fullName))
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		ChemicalElements ch = new ChemicalElements(1, "H", "Hydrogen");
		ChemicalElements ch1 = new ChemicalElements(1, "H", "Hydrogen");
		ChemicalElements ch2 = new ChemicalElements(2, "He", "Helium");
		ChemicalElements ch3 = new ChemicalElements(7, "N", "Nitrogen");
		ChemicalElements ch4 = new ChemicalElements(8, "O", "Oxygen");
		System.out.println(ch.isAlkaliMetal());
		System.out.println(ch.isTransitionMetal());
		System.out.println(ch.isMetal());
		System.out.println(ch.equals(ch1));
		System.out.println((ch == ch1)?"true":"false");
	}
}

