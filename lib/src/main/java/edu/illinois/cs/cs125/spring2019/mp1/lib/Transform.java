package edu.illinois.cs.cs125.spring2019.mp1.lib;

/**
 * A class that runs implements several several simple transformations on 2D image arrays.
 */
public class Transform {
    /**
     * Shift the image up by the specified amount.
     * @param originalImage the 2D array that stores 32-bit rgba pixel data
     * @param amount the number of vertical up-shifts
     * @return the originalImage shifted up by amount
     */
    public static RGBAPixel[][] shiftUp(final RGBAPixel[][] originalImage, final int amount) {
        //Declared a new RGBAPixel[][] "shiftedImage" of same dimensions as "originalImage"
        RGBAPixel[][] shiftedImage = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                if (i < originalImage.length - amount) {
                    shiftedImage[i][j] = originalImage[i + 1][j];
                } else {
                    shiftedImage[i][j] = RGBAPixel.getFillValue();
                }
            }
        }
        return shiftedImage;
    }
}
