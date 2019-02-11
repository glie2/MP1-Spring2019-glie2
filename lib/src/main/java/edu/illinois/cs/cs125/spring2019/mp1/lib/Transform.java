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

        int m = originalImage.length; //"# of rows"
        int n = originalImage[0].length; //"# of columns"
        int big = m;
        int small = n;

        if (m > n) {
            big = m;
            small = n;
        } else if (n > m) {
            big = n;
            small = m;
        }

        int boundary = (big - small) / 2;

        RGBAPixel[][] rotatedImage = new RGBAPixel[n][m]; //invert rows/columns of originalImage
        //If square matrix, simply rotate right
        if (m == n) {
            for (int i = 0; i < originalImage.length; i++) {
                for (int j = 0; j < originalImage[i].length; j++) {
                    rotatedImage[j][originalImage.length - 1 - i] = originalImage[i][j];
                }
            }
            return rotatedImage;
        } else if (m > n) {
            for (int i = 0; i < rotatedImage.length; i++) {
                for (int j = 0; j < rotatedImage[i].length; j++) {
                    if (j < boundary) {
                        rotatedImage[i][j] = RGBAPixel.getFillValue();
                    } else if ((j >= boundary) && (j < rotatedImage[i].length - boundary)) {
                        rotatedImage[j][originalImage.length - 1 - i] = originalImage[i][j];
                    } else if (j >= rotatedImage[i].length - boundary) {
                        rotatedImage[i][j] = RGBAPixel.getFillValue();
                    }
                }
            }
            return rotatedImage;
        } else {
            for (int i = 0; i < rotatedImage.length; i++) {
                for (int j = 0; j < rotatedImage[i].length; j++) {
                    if (i < boundary) {
                        rotatedImage[i][j] = RGBAPixel.getFillValue();
                    } else if ((i >= boundary) && (i < rotatedImage.length - boundary)) {
                        rotatedImage[j][originalImage.length - 1 - i] = originalImage[i][j];
                    } else if (i >= rotatedImage.length - boundary) {
                        rotatedImage[i][j] = RGBAPixel.getFillValue();
                    }
                }
            }
            return rotatedImage;

        }
        /**
        //Rotate right for a square matrix
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                rotatedImage[j][originalImage.length - 1 - i] = originalImage[i][j];
            }
        }
         */
    }

    /**
     * Flip the image on the vertical axis across its center.
     * @param originalImage the image to flip on its vertical axis
     * @return the flipped image
     */
    public static RGBAPixel[][] flipVertical(final RGBAPixel[][] originalImage) {

        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] flippedImage = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                flippedImage[i][originalImage[i].length - 1 - i] = originalImage[i][j];
            }
        }
        return flippedImage;
    }

    /**
     * Flip the image on the horizontal axis across its center.
     * @param originalImage the image to flip on its horizontal axis
     * @return the flipped image
     */
    public static RGBAPixel[][] flipHorizontal(final RGBAPixel[][] originalImage) {

        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] flippedImage = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                flippedImage[originalImage.length - 1 - i][j] = originalImage[i][j];
            }
        }
        return flippedImage;
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

        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] expandedImage = new RGBAPixel[originalImage.length][originalImage[0].length];
        int middleFirst = (expandedImage[0].length / 2) - 1;
        int middleLast = (expandedImage[0].length / 2);

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = middleLast; j < originalImage[i].length; j++) {
                int column = ((j - middleLast) / amount) + middleLast;
                expandedImage[i][j] = originalImage[i][column];
            }
        }

        for (int i = 0; i < originalImage.length; i++) {
            for (int j = middleFirst; j >= 0; j--) {
                int column = ((j - middleFirst) / amount) + middleFirst;
                expandedImage[i][j] = originalImage[i][column];
            }
        }
        return expandedImage;
    }

    /**
     * Expand in the horizontal axis around the image center.
     * @param originalImage the image to expand
     * @param amount the factor by which the image's width is increased
     * @return the expanded image
     */
    public static RGBAPixel[][] expandHorizontal(final RGBAPixel[][] originalImage, final int amount) {

        if (originalImage == null) {
            return null;
        }

        RGBAPixel[][] expandedImage = new RGBAPixel[originalImage.length][originalImage[0].length];
        int middleFirst = (expandedImage.length / 2) - 1;
        int middleLast = (expandedImage.length / 2);

        for (int i = middleLast; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                int row = ((i - middleLast) / amount) + middleLast;
                expandedImage[i][j] = originalImage[row][j];
            }
        }

        for (int i = middleFirst; i >= 0; i--) {
            for (int j = 0; j < originalImage[i].length; j++) {
                int row = ((i - middleFirst) / amount) + middleFirst;
                expandedImage[i][j] = originalImage[row][j];
            }
        }
        return expandedImage;
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
}
