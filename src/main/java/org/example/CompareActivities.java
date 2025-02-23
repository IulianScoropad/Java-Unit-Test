package org.example;


public class CompareActivities {
    private int cal;

    public CompareActivities(int cal) {
        this.cal = cal;
    }

    /**
     * The method checks the type of the activity and based on this type it calculates the difference between the attribute
     * of the class (cal) and the value returned by calculateCalories called on the corresponding activity.
     * @param  type  specifies the type of the activity (the possible types are provided in the ActivityType enum)
     * @param  v     variable parameter (may contain 0 to n elements and functions as an array) representing the values
     *               of the attributes for the respective activity
     * @return       the difference between the attribute of the class and the value returned by calculateCalories called on
     *               the corresponding activity
     */
    public int compare(ActivityType type, int... v) {

        if(type == ActivityType.BIKE){
            if(v.length == 2) {
                Bike bike = new Bike(v[0], v[1]);
                cal = bike.calculateCalories();
                return cal;
            }
            else {
                throw new IncorrectNumberOfParameters("Activity bike need to have 2 parameter");
            }
        }

        if(type == ActivityType.RUN){
            if(v.length == 1){
                Run run = new Run(v[0]);
                cal = run.calculateCalories();
                return cal;
            }else{
                throw new IncorrectNumberOfParameters("Activity run need to have 1 parameter");
            }
        }

        if(type == ActivityType.SWIM){
            if(v.length == 2){
                Swim swim =  new Swim(v[0],v[1]);
                cal = swim.calculateCalories();
                return cal;
            }
            else {
                throw new IncorrectNumberOfParameters("Activity swim need to have 2 parameter");
        }
        }
        if(type == ActivityType.UNKNOWNACTIVITY){
            throw new IncorrectTypeOfActivity("I don't know this activity");

        }

        return 0;
    }
}
