package org.builder.BuilderDesignPattern;

/**
 * @author Irfan Shaikh
 *
 */
public class TicketBooking {

	// Required Fields
	private String from;
	private String to;
	private String type;
	private String contactNo;

	// optional field;
	private String emailAddress;
	private boolean isAnyCuponApplied;
	private boolean travelInshurance;
	private String bookingType;

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getType() {
		return type;
	}

	public String getContactNo() {
		return contactNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public boolean isAnyCuponApplied() {
		return isAnyCuponApplied;
	}

	public boolean isTravelInshurance() {
		return travelInshurance;
	}

	public String getBookingType() {
		return bookingType;
	}



	public TicketBooking(TicketBookinguilder builder) {
		this.from = builder.from;
		this.to = builder.to;
		this.type =builder. type;
		this.contactNo = builder.contactNo;
		this.emailAddress = builder.emailAddress;
		this.isAnyCuponApplied = builder.isAnyCuponApplied;
		this.travelInshurance = builder.travelInshurance;
		this.bookingType = builder.bookingType;
	}

	@Override
	public String toString() {
		return "TicketBooking [from=" + from + ", to=" + to + ", type=" + type + ", contactNo=" + contactNo
				+ ", emailAddress=" + emailAddress + ", isAnyCuponApplied=" + isAnyCuponApplied + ", travelInshurance="
				+ travelInshurance + ", bookingType=" + bookingType + "]";
	}


	public static class TicketBookinguilder {

		// Required Fields
		private String from;
		private String to;
		private String type;
		private String contactNo;

		// optional field;
		private String emailAddress;
		private boolean isAnyCuponApplied;
		private boolean travelInshurance;
		private String bookingType;


		@Override
		public String toString() {
			return "TicketBookinguilder [from=" + from + ", to=" + to + ", type=" + type + ", contactNo=" + contactNo
					+ ", emailAddress=" + emailAddress + ", isAnyCuponApplied=" + isAnyCuponApplied
					+ ", travelInshurance=" + travelInshurance + ", bookingType=" + bookingType + "]";
		}
		public TicketBookinguilder setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
			return this;
		}
		public TicketBookinguilder setAnyCuponApplied(boolean isAnyCuponApplied) {
			this.isAnyCuponApplied = isAnyCuponApplied;
			return this;
		}
		public TicketBookinguilder setTravelInshurance(boolean travelInshurance) {
			this.travelInshurance = travelInshurance;
			return this;
		}
		public TicketBookinguilder setBookingType(String bookingType) {
			this.bookingType = bookingType;
			return this;
		}

		public TicketBookinguilder(String from, String to, String type, String contactNo) {
			this.from = from;
			this.to = to;
			this.type = type;
			this.contactNo = contactNo;
		}
		public TicketBooking build() {
			return new TicketBooking(this);
		}


	}
	public static void main(String[] args) {
		TicketBooking book = new TicketBooking.TicketBookinguilder("latur", "pune", "travel", "123231").setAnyCuponApplied(true).setBookingType("agent").setTravelInshurance(true).build();
		System.out.println(book);
	}


}
