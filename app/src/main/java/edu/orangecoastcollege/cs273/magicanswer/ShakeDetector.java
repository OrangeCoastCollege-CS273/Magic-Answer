package edu.orangecoastcollege.cs273.magicanswer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import static android.content.ContentValues.TAG;


public class ShakeDetector implements SensorEventListener {
    public static final long ELAPSED_TIME = 1000L;
    public static final float THRESHOLD = 25;

    private long lastTimestamp;

    private OnShakeListener mListener;

    public ShakeDetector(OnShakeListener listener) {
        this.mListener = listener;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float xForce = sensorEvent.values[0] - SensorManager.GRAVITY_EARTH;
            float yForce = sensorEvent.values[1];
            float zForce = sensorEvent.values[2];

            float netForce = (float) Math.sqrt(Math.pow(xForce, 2) + Math.pow(yForce, 2) + Math.pow(zForce, 2));
            if (netForce >= THRESHOLD && System.currentTimeMillis() > lastTimestamp + ELAPSED_TIME) {
                Log.i(TAG, "onSensorChanged: " + sensorEvent.timestamp + ", " + lastTimestamp);
                lastTimestamp = System.currentTimeMillis();
                mListener.onShake();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {}

    public interface OnShakeListener {
        void onShake();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShakeDetector that = (ShakeDetector) o;

        if (lastTimestamp != that.lastTimestamp) return false;
        return mListener != null ? mListener.equals(that.mListener) : that.mListener == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (lastTimestamp ^ (lastTimestamp >>> 32));
        result = 31 * result + (mListener != null ? mListener.hashCode() : 0);
        return result;
    }
}
