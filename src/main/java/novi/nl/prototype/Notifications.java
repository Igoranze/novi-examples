package novi.nl.prototype;

public class Notifications {

	private boolean led;
	private int lastMessages = 1;
	
	public void turnOnLed(boolean turnOn) {
		this.led = turnOn;
	}
	
	public int getNotifications() {
		// Geef het aantal nieuwe berichten
		return 2;
	}
	
	public void checkNotifications() {
		// 1. Haal alle nieuwe berichten op
		int newMessages = getNotifications();
		
		// 2. Kijk of ik meer of minder nieuwe berichten heb:
		if (lastMessages > newMessages) {
			// 2.b Ik heb er vast al een paar gelezen, want mijn nieuwe zijn minder dan de laatste
			// Zet het ledje uit en sla de huidige aantal op in de nieuwe
			turnOnLed(false);
			this.lastMessages = newMessages;
		}
		//... Rest of code
	}
}
