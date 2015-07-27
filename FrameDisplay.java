/**
 * Author: nguyenquockhai create on 24/07/2015 at Robotics Club.
 * Desc:
 */

class FrameDisplay extends AsyncTask<Void, Void, Bitmap>
{
    private final WeakReference<ImageView> imageViewReference;
    private final Bitmap bitmap;

    public FrameDisplay(ImageView imageView, Bitmap bmp) {
        // Use a WeakReference to ensure the ImageView can be garbage collected
        imageViewReference = new WeakReference<ImageView>(imageView);
        bitmap = bmp;
    }

    // Decode image in background.
    @Override
	protected Bitmap doInBackground(Void... params) {
        return bitmap;
    }

    // Once complete, see if ImageView is still around and set bitmap.
    @Override
	protected void onPostExecute(Bitmap bmp) {
        if (bmp != null) {
            final ImageView imageView = imageViewReference.get();
            if (imageView != null) {
                imageView.setImageBitmap(bmp);
            }
        }
    }
}
