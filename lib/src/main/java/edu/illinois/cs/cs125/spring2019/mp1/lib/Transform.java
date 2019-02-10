package edu.illinois.cs.cs125.spring2019.mp1.lib;

/**
 * A class that runs implements several several simple transformations on 2D image arrays.
 */
public class Transform {

    /**
     * Remove a green screen mask from an image.
     * @param originalImage the image to remove a green screen from
     * @return the image with the green screen removed
     */
    public static RGBAPixel[][] greenScreen(final RGBAPixel[][] originalImage) {
        RGBAPixel[][] modifiedImage = new RGBAPixel[originalImage.length][originalImage[0].length];

        for (int i = 0; i < modifiedImage.length; i++) {
            for (int j = 0; j < modifiedImage[i].length; j++) {

                if (originalImage[i][j].getGreen() != 0) {
                    modifiedImage[i][j] = RGBAPixel.getFillValue();
                } else {
                    modifiedImage[i][j] = originalImage[i][j];
                }
            }
        }
        return modifiedImage;
    }

    /**
     * Shift the image up by the specified amount.
     * @param originalImage the image to shift up
     * @param amount the amount to shift the image up
     * @return the shifted image
     */
    public static RGBAPixel[][] shiftLeft(final RGBAPixel[][] originalImage, final int amount) {
        //Declared a new RGBAPixel[][] "shiftedImage" of same dimensions as "originalImage"
        RGBAPixel[][] shiftedImage = new RGBAPixel[originalImage.length][originalImage[0].length];
        if (amount >= originalImage.length) {
            for (int i = 0; i < originalImage.length; i++) {
                for (int j = 0; j < originalImage[i].length; j++) {
                    shiftedImage[i][j] = RGBAPixel.getFillValue();
                }
            }
            return shiftedImage;
        }

        for (int i = 0; i < originalImage.length - amount; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                shiftedImage[i][j] = originalImage[i + amount][j];
            }
        }

        for (int i = originalImage.length - amount; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                shiftedImage[i][j] = RGBAPixel.getFillValue();
            }
        }
        return shiftedImage;
    }

    /**
     * Shift the image down by the specified amount.
     * @param originalImage the image to shift down
     * @param amount the amount to shift the image down
     * @return the shifted image
     */
    public static RGBAPixel[][] shiftRight(final RGBAPixel[][] originalImage, final int amount) {
        //Declared a new RGBAPixel[][] "shiftedImage" of same dimensions as "originalImage"
        RGBAPixel[][] shiftedImage = new RGBAPixel[originalImage.length][originalImage[0].length];
        if (amount >= originalImage.length) {
            for (int i = 0; i < originalImage.length; i++) {
                for (int j = 0; j < originalImage[i].length; j++) {
                    shiftedImage[i][j] = RGBAPixel.getFillValue();
                }
            }
            return shiftedImage;
        }

        for (int i = 0; i < amount; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                shiftedImage[i][j] = RGBAPixel.getFillValue();
            }
        }
        for (int i = amount; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                shiftedImage[i][j] = originalImage[i - amount][j];
            }
        }
        return shiftedImage;
    }

    /**
     * Shift the image left by the specified amount.
     * @param originalImage the image to shift to the left
     * @param amount the amount to shift the image to the left
     * @return the shifted image
     */
    public static RGBAPixel[][] shiftUp(final RGBAPixel[][] originalImage, final int amount) {
        //Declared a new RGBAPixel[][] "shiftedImage" of same dimensions as "originalImage"
        RGBAPixel[][] shiftedImage = new RGBAPixel[originalImage.length][originalImage[0].length];
        if (amount >= originalImage[0].length) {
            for (int i = 0; i < originalImage.length; i++) {
                for (int j = 0; j < originalImage[i].length; j++) {
                    shiftedImage[i][j] = RGBAPixel.getFillValue();
                }
            }
            return shiftedImage;
        }

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length - amount; j++) {
                shiftedImage[i][j] = originalImage[i][j + amount];
            }
        }

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = originalImage[i].length - amount; j < originalImage[i].length; j++) {
                shiftedImage[i][j] = RGBAPixel.getFillValue();
            }
        }
        return shiftedImage;
    }

    /**
     * Shift the image right by the specified amount.
     * @param originalImage the image to shift to the right
     * @param amount the amount to shift the image to the right
     * @return the shifted image
     */
    public static RGBAPixel[][] shiftDown(final RGBAPixel[][] originalImage, final int amount) {
        //Declared a new RGBAPixel[][] "shiftedImage" of same dimensions as "originalImage"
        RGBAPixel[][] shiftedImage = new RGBAPixel[originalImage.length][originalImage[0].length];
        if (amount >= originalImage[0].length) {
            for (int i = 0; i < originalImage.length; i++) {
                for (int j = 0; j < originalImage[i].length; j++) {
                    shiftedImage[i][j] = RGBAPixel.getFillValue();
                }
            }
            return shiftedImage;
        } //else if (amount < 0) {return shiftUP(originalImage, amount) }

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = amount; j < originalImage[0].length; j++) {
                shiftedImage[i][j] = originalImage[i][j - amount];
            }
        }

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < amount; j++) {
                shiftedImage[i][j] = RGBAPixel.getFillValue();
            }
        }
        return shiftedImage;
    }

    /**
     * Rotate the image left by 90 degrees around its center.
     * @param originalImage the image to rotate left 90 degrees
     * @return the rotated image
     */
    public static RGBAPixel[][] rotateLeft(final RGBAPixel[][] originalImage) {
        return null;
    }

    /**
     * Rotate the image by 90 degrees around its center.
     * @param originalImage the image to rotate right 90 degrees
     * @return the rotated image
     */
    public static RGBAPixel[][] rotateRight(final RGBAPixel[][] originalImage) {
        return null;
    }

    /**
     * Flip the image on the vertical axis across its center.
     * @param originalImage the image to flip on its vertical axis
     * @return the flipped image
     */
    public static RGBAPixel[][] flipVertical(final RGBAPixel[][] originalImage) {
        return null;
    }

    /**
     * Flip the image on the horizontal axis across its center.
     * @param originalImage the image to flip on its horizontal axis
     * @return the flipped image
     */
    public static RGBAPixel[][] flipHorizontal(final RGBAPixel[][] originalImage) {
        return null;
    }

    /**
     * Shrink in the vertical axis around the image center.
     * @param originalImage the image to shrink
     * @param amount the factor by which the image's height is reduced
     * @return the shrunken image
     */
    public static RGBAPixel[][] shrinkVertical(final RGBAPixel[][] originalImage, final int amount) {
        return null;
    }

    /**
     * Expand in the vertical axis around the image center.
     * @param originalImage the image to expand
     * @param amount the factor by which the image's height is increased
     * @return the expanded image
     */
    public static RGBAPixel[][] expandVertical(final RGBAPixel[][] originalImage, final int amount) {
        return null;
    }

    /**
     * Shrink in the horizontal axis around the image center.
     * @param originalImage the image to shrink
     * @param amount the factor by which the image's width is reduced
     * @return the shrunken image
     */
    public static RGBAPixel[][] shrinkHorizontal(final RGBAPixel[][] originalImage, final int amount) {
        return null;
    }

    /**
     * Expand in the horizontal axis around the image center.
     * @param originalImage the image to expand
     * @param amount the factor by which the image's width is increased
     * @return the expanded image
     */
    public static RGBAPixel[][] expandHorizontal(final RGBAPixel[][] originalImage, final int amount) {
        return null;
    }


}
