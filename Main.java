package e2piApprox;

public class Main {
    public static void main(String[] args){
        //System.out.println(compositesimpson13(0, 6,12));
        for (int i = 0; i <= 33; i++){
            e = approxE(i);
            System.out.println(i+ " "+ approxPi()+" " + (Math.PI - approxPi()));
        }
        System.out.println(approxPi()+" " + (Math.PI - approxPi()));

    }   



    public static double e = approxE(12);


    public static double regsimpson13(int a, int b){
        double sum = f(a)+4*f((a+b)/2)+f(b);

        return sum * (b-a) / 6;
    }
    public static double compositesimpson13(double a, double b, double n){
        double sum = f(a) + f(b);
        double h = (b-a)/n;
        for (double i = 1; i <= n/2; i++){
            sum += 4*f( a+(2*i-1)*h);   
        }
        for (double i = 1; i <= n/2-1; i++){
            sum += 2*f(a+2*i*h);
        }
        //System.out.println(sum);

        return sum * (b-a) / (3*n);
    }
    public static double approxPi(){
        return Math.pow(2*(compositesimpson13(0, 20, 1_000_000)), 2);
    }


    public static double approxE(int n){
        double e = 1;
        n = n > 33 ? 33 : n;
        for (int i = 1; i <= n; i++){
            e += 1/factorial(i);
        }
        return e;
    }
    public static double factorial(int n){
        int out = 1;
        for (int i = 2; i <= n; i++){
            out *= i;
        }
        return out;
    }
    public static double f(double x){
        return Math.pow(e, -(Math.pow(x, 2)));
        //return Math.pow(e, -x);
    }
}
