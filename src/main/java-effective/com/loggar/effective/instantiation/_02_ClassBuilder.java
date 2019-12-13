package com.loggar.effective.instantiation;

/**
 * Consider Builer to create instance of classes that have many fields.
 */
public class _02_ClassBuilder {
	public static void main(String[] args) {
		NutritionFacts cocacola = new NutritionFacts.NutritionFactsBuilder(240, 8)
				.calories(100)
				.sodium(35)
				.carbohydrate(27)
				.build();
		
		System.out.println(cocacola);
	}
	
	/**
	 * Builder interface for all class builder.
	 */
	public interface Builder<T> {
		public T build();
	}
	
	static class NutritionFacts {
		private final int servingSize;
		private final int servings;
		private final int calories;
		private final int fat;
		private final int sodium;
		private final int carbohydrate;
		
		private NutritionFacts(NutritionFactsBuilder builder) {
			servingSize = builder.servingSize;
			servings = builder.servings;
			calories = builder.calories;
			fat = builder.fat;
			sodium = builder.sodium;
			carbohydrate = builder.carbohydrate;
		}
		
		public static class NutritionFactsBuilder implements Builder<NutritionFacts> {
			// required parameters
			private final int servingSize;
			private final int servings;
			
			// optional parameters - initialized to default values.
			private int calories = 0;
			private int fat = 0;
			private int sodium = 0;
			private int carbohydrate = 0;
			
			public NutritionFactsBuilder(int servingSize, int servings) {
				this.servingSize = servingSize;
				this.servings = servings;
			}
			
			public NutritionFactsBuilder calories(int val) { this.calories = val; return this;}
			public NutritionFactsBuilder fat(int val) { fat = val; return this;}
			public NutritionFactsBuilder sodium(int val) { sodium = val; return this;}
			public NutritionFactsBuilder carbohydrate(int val) { carbohydrate = val; return this;}
			
			public NutritionFacts build() {
				return new NutritionFacts(this);
			}
		}
		
		public int getServingSize() {
			return servingSize;
		}

		public int getServings() {
			return servings;
		}

		public int getCalories() {
			return calories;
		}

		public int getFat() {
			return fat;
		}

		public int getSodium() {
			return sodium;
		}

		public int getCarbohydrate() {
			return carbohydrate;
		}

		@Override
		public String toString() {
			StringBuilder builder2 = new StringBuilder();
			builder2.append("NutritionFacts [servingSize=").append(servingSize).append(", servings=").append(servings).append(", calories=").append(calories).append(", fat=").append(fat).append(", sodium=").append(sodium).append(", carbohydrate=").append(carbohydrate).append("]");
			return builder2.toString();
		}
	}
}
