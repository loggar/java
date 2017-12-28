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
public enum _07_Phase {
	SOLID, LIQUID, GAS;
	public enum Transition {
		MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID), BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID), SUBLIME(SOLID,
				GAS), DEPOSIT(GAS, SOLID);
		final _07_Phase src;
		final _07_Phase dst;

		Transition(_07_Phase src, _07_Phase dst) {
			this.src = src;
			this.dst = dst;
		}// Initialize the phase transition map

		private static final Map<_07_Phase, Map<_07_Phase, Transition>> m = new EnumMap<_07_Phase, Map<_07_Phase, Transition>>(
				_07_Phase.class);
		static {
			for (_07_Phase p : _07_Phase.values())
				m.put(p, new EnumMap<_07_Phase, Transition>(_07_Phase.class));
			for (Transition trans : Transition.values())
				m.get(trans.src).put(trans.dst, trans);
		}

		public static Transition from(_07_Phase src, _07_Phase dst) {
			return m.get(src).get(dst);
		}
	}
}
