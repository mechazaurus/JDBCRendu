package com.polytech.bsm.model;

public enum LocalType {

	BATHROOM {
		@Override
		public String toString() {
			return "Bathroom";
		}
	},
	BEDROOM {
		@Override
		public String toString() {
			return "Bedroom";
		}
	},
	KITCHEN {
		@Override
		public String toString() {
			return "Kitchen";
		}
	},
}
