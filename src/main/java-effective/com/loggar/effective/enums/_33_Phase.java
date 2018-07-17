package com.loggar.effective.enums;

import java.util.EnumMap;
import java.util.Map;

/*
// Using ordinal() to index array of arrays - DON'T DO THIS!
public enum Phase {
	SOLID, LIQUID, GAS;
	public enum Transition {
		MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;
		// Rows indexed by src-ordinal, cols by dst-ordinal
		private static final Transition[][] TRANSITIONS = { { null, MELT, SUBLIME }, { FREEZE, null, BOIL },
				{ DEPOSIT, CONDENSE, null } };

		// Returns the phase transition from one phase to another
		public static Transition from(Phase src, Phase dst) {
			return TRANSITIONS[src.ordinal()][dst.ordinal()];
		}
	}
}
*/

/**
 * Use EnumMap instead of ordinal indexing Using a nested EnumMap to associate
 * data with enum pairs
 */
public enum _33_Phase {
	SOLID, LIQUID, GAS;
	public enum Transition {
		MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID), BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID), SUBLIME(SOLID,
				GAS), DEPOSIT(GAS, SOLID);
		final _33_Phase src;
		final _33_Phase dst;

		Transition(_33_Phase src, _33_Phase dst) {
			this.src = src;
			this.dst = dst;
		}// Initialize the phase transition map

		private static final Map<_33_Phase, Map<_33_Phase, Transition>> m = new EnumMap<_33_Phase, Map<_33_Phase, Transition>>(
				_33_Phase.class);
		static {
			for (_33_Phase p : _33_Phase.values())
				m.put(p, new EnumMap<_33_Phase, Transition>(_33_Phase.class));
			for (Transition trans : Transition.values())
				m.get(trans.src).put(trans.dst, trans);
		}

		public static Transition from(_33_Phase src, _33_Phase dst) {
			return m.get(src).get(dst);
		}
	}
}
