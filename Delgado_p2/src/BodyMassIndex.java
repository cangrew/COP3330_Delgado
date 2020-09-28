public class BodyMassIndex {
  double h;
  double w;

  public BodyMassIndex(double height, double weight){
      h = height;
      w = weight;
  }

  public double bmiScore(){
    return 703*w/(h*h);
  }

  public String bmiCategory(){
    double temp = bmiScore();
    if(temp < 18.5){
      return "Underweight";
    }
    else if(temp >= 18.5 && temp <= 24.5){
      return "Normal weight";
    }
    else if(temp >= 25 && temp <= 29.9){
      return "Overweight";
    }
    return "Obesity";
  }

}
