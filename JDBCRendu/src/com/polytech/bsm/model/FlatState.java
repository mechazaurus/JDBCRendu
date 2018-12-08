package com.polytech.bsm.model;

public enum FlatState {

	UNDER_CONSTRUCTION {
		@Override
		public String toString() {
			return "Under construction";
		}
	},
	READY {
		@Override
		public String toString() {
			return "Ready";
		}
	},
}
