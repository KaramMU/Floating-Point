
package floating.point;

/**
 *
 * @author Algharabeh
 * // Karam Algharabeh
 * // Kmalgharabeh2016@spartans.manchester.edu
 */

public class FloatingPoint {
    
     public static void main(String[] args) {
     float hw= (float)Math.pow(3, 27);
     float ka=(float)(Double.NaN);
     System.out.println(ka+"="+decoding(ka));
     System.out.println(hw+"--------" + decoding(hw));
     
    }

    public static float decoding (float hw){
        float FinalizedFloat=0;
        int hwbit=Float.floatToRawIntBits(hw);
        int signbit=hwbit>>>31;
        int thevaluesign;
        
        if(signbit==0) //  It assigns the value sign for the number
            thevaluesign=1;   // if it equals zero, the value sign will be zero, otherwise it will equal -1.
        else
            thevaluesign=-1;
        
        int expbit= hwbit<<1;
        int finalizedexpbit=expbit>>>24;
        System.out.println(finalizedexpbit);
        int mantissa=(hwbit<<9)>>>9;
        
        if(finalizedexpbit==0){ //  In the case of Denormlized 
            int bias=127;
            int E=1-bias;
            FinalizedFloat = thevaluesign*(float)((mantissa/Math.pow(2,23))*Math.pow(2, E));
            
        }
        
        else if (finalizedexpbit==255){ //In the case in which its infinty or Nan
            double infinity=Double.POSITIVE_INFINITY; // sets a double to infinity
            
            if (mantissa!=0) //In case where its NaN
                FinalizedFloat = (float)(infinity-infinity);
            else // case where its + or - infinity
                FinalizedFloat=(float)(thevaluesign*infinity);
        }
        else{ //  In the normilized case
            int bias=127;
            int E=finalizedexpbit-bias;
            FinalizedFloat=thevaluesign*(float)((Math.pow(2, 23)+mantissa)/Math.pow(2, 23)*Math.pow(2, E));
            
        }
        
        return FinalizedFloat;
    }
   
    }
    
    
