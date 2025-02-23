import org.example.*;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestClass {
public Bike bike;
public Run run;
public Swim swim;

public CompareActivities activities = new CompareActivities(300);

  @Test
    void getBikeCalculateCalories(){
      bike = new Bike(6,10);
      assertEquals(600,bike.calculateCalories());
  }
  @Test
  void getRunCalculateCalories(){
    run = new Run(6);
    assertEquals(600,run.calculateCalories());
  }
  @Test
  void getSwimCalculateCalories(){
    swim = new Swim(5,10);
    assertEquals(240, swim.calculateCalories());
  }

  @Test
    void getBikeCalculateCaloriesWithZeroKmDistance(){
      Exception exception = assertThrows(IncorrectValueException.class, ()-> new Bike(0,10));
      assertEquals("The number of kilometers should be higher than 0", exception.getMessage());
  }

  @Test
  void getBikeCalculateCaloriesWithZeroNumberGears(){
    Exception exception = assertThrows(IncorrectValueException.class, ()-> new Bike(10,0));
    assertEquals("The number of gears should be higher than 0", exception.getMessage());
  }

  @Test
  void getSwimCalculateCaloriesWithZeroKmDistance(){
    Exception exception = assertThrows(IncorrectValueException.class, ()-> new Swim(0,10));
    assertEquals("The number of kilometers should be higher than 0", exception.getMessage());
  }

  @Test
  void getRunCalculateCaloriesWithZeroKmDistance(){
    Exception exception = assertThrows(IncorrectValueException.class, ()-> new Run(0));
    assertEquals("The number of kilometers should be higher than 0", exception.getMessage());
  }

  @Test
  void getSwimCalculateCaloriesWithMinusOneWaterTemperature(){
    Exception exception = assertThrows(IncorrectValueException.class, ()-> new Swim(100,-1));
    assertEquals("The water temperature should be between 0 and 30", exception.getMessage());
  }

  @Test
  void getSwimCalculateCaloriesWith31WaterTemperature(){
    Exception exception = assertThrows(IncorrectValueException.class, ()-> new Swim(100,31));
    assertEquals("The water temperature should be between 0 and 30", exception.getMessage());
  }

  @Test
  void getInvalidNumberOfParametersForSwimActivity(){

    Exception exception = assertThrows(IncorrectNumberOfParameters.class, ()-> activities.compare(ActivityType.SWIM,20,0,12));
    assertEquals("Activity swim need to have 2 parameter", exception.getMessage());
  }

  @Test
  void getInvalidNumberOfParametersForRunActivity(){
    Exception exception = assertThrows(IncorrectNumberOfParameters.class, ()-> activities.compare(ActivityType.RUN,1,3));
    assertEquals("Activity run need to have 1 parameter", exception.getMessage());
  }

  @Test
  void getInvalidNumberOfParametersForBikeActivity(){
    Exception exception = assertThrows(IncorrectNumberOfParameters.class, ()-> activities.compare(ActivityType.BIKE,1,3,5));
    assertEquals("Activity bike need to have 2 parameter", exception.getMessage());
  }
  @Test
  void getUnknownActivity(){
    Exception exception = assertThrows(IncorrectTypeOfActivity.class, ()-> activities.compare(ActivityType.UNKNOWNACTIVITY,1,3,5));
    assertEquals("I don't know this activity", exception.getMessage());
  }
}
