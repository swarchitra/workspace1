public class ChemicalElementsApp {
	public static void main(String[] args) {
		ChemicalElements ch = new ChemicalElements(1, "H", "Hydrogen");
		ChemicalElements ch1 = new ChemicalElements(1, "H", "Hydrogen");
		ChemicalElements ch2 = new ChemicalElements(2, "He", "Helium");
		ChemicalElements ch3 = new ChemicalElements(7, "N", "Nitrogen");
		ChemicalElements ch4 = new ChemicalElements(8, "O", "Oxygen");
		System.out.println(ch.isAlkaliMetal());
		System.out.println(ch2.isTransitionMetal());
		System.out.println(ch3.isMetal());
		System.out.println(ch4.equals(ch1));
		System.out.println((ch == ch1)?"true":"false");
		System.out.println(ch.getAtomicNumber());
		System.out.println(ch4.getSymbolicName());
		System.out.println(ch3.getFullName());
		ch.setAtomicNumber(10);
		System.out.println(ch.getAtomicNumber());
		
	}
}
