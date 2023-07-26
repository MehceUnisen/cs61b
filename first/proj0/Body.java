package proj0;

public class Body {
    static final double G = 6.67e-11;

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Body(double xP, double yP, double xV,
            double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Body(Body b) {
        b.xxPos = xxPos;
        b.yyPos = yyPos;
        b.xxVel = xxVel;
        b.yyVel = yyVel;
        b.mass = mass;
        b.imgFileName = imgFileName;
    }

    public double calcDistanceX(Body body) {
        return body.xxPos - this.xxPos;
    }

    public double calcDistanceY(Body body) {
        return body.yyPos - this.yyPos;
    }

    public double calcDistance(Body body) {
        return Math.pow(calcDistanceX(body), 2) + Math.pow(calcDistanceY(body), 2);
        // returns the r^2
    }

    public double calcForceExertedBy(Body body) {
        return G * body.mass * this.mass / calcDistance((body));
    }

    public double calcForceExertedByX(Body body) {
        return calcForceExertedBy(body) * calcDistanceX(body) / Math.sqrt(calcDistance(body));
    }

    public double calcForceExertedByY(Body body) {
        return calcForceExertedBy(body) * calcDistanceY(body) / Math.sqrt(calcDistance(body));
    }

    public double calcNetForceExertedByX(Body[] bodies) {
        double f = 0.0;
        for (int i = 0; i < bodies.length; i++) {
            if (this.equals(bodies[i])) {
                continue;
            }
            f += calcForceExertedByX(bodies[i]);
        }
        return f;
    }

    public double calcNetForceExertedByY(Body[] bodies) {
        double f = 0.0;
        for (int i = 0; i < bodies.length; i++) {
            if (this.equals(bodies[i])) {
                continue;
            }
            f += calcForceExertedByY(bodies[i]);
        }
        return f;
    }

    public void update(double t, double xForce, double yForce) {
        this.xxVel += xForce * t / this.mass;
        this.yyVel += yForce * t / this.mass;

        this.xxPos += xxVel * t;
        this.yyPos += yyVel * t;
    }
}
