package cn.org.octopus.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

public class MyApplication extends Application {
	
	public static String TAG_ACTIVITY_LIFE = "cn.org.octopus.application.activity.life";
	
	/** 用于数据传递的 Map 集合 */
	private Map<String, Object> transferMap;
	/** 用于缓存数据的 Map 集合 */
	private Map<String, Object> cacheMap; 
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		//初始化用于数据传递的 Map 集合
		transferMap = new HashMap<String, Object>();
		//初始化用于数据缓存的 Map 集合
		cacheMap = new HashMap<String, Object>();
		
		//注册 Activity 声明周期监听器
		registerActivityLifecycleCallbacks(new MyActivityLifecycleCallbacks());
		
		//注册异常日志处理类
		CrashHandler crashHandler = CrashHandler.getInstance();
		//初始化异常日志处理类, 注意在开发过程中这个可以注释掉
		crashHandler.init(getApplicationContext());
	}

	/**
	 * 获取数据传递 Map 集合
	 * @return
	 * 		数据传递 Map 集合
	 */
	public Map<String, Object> getTransferMap() {
		return transferMap;
	}

	/**
	 * 获取数据缓存 Map 集合
	 * @return
	 * 		数据缓存 Map 集合
	 */
	public Map<String, Object> getCacheMap() {
		return cacheMap;
	}
	
	
	/**
	 * Activity 生命周期监听
	 * 		如果不需要可以不使用该方法
	 * @author octopus
	 *
	 */
	class MyActivityLifecycleCallbacks implements ActivityLifecycleCallbacks{

		@Override
		public void onActivityCreated(Activity activity,
				Bundle savedInstanceState) {
			Log.i(TAG_ACTIVITY_LIFE, activity.getClass().getName() + " : onActivityCreated");
		}

		@Override
		public void onActivityStarted(Activity activity) {
			Log.i(TAG_ACTIVITY_LIFE, activity.getClass().getName() + " : onActivityStarted");
		}

		@Override
		public void onActivityResumed(Activity activity) {
			Log.i(TAG_ACTIVITY_LIFE, activity.getClass().getName() + " : onActivityResumed");
		}

		@Override
		public void onActivityPaused(Activity activity) {
			Log.i(TAG_ACTIVITY_LIFE, activity.getClass().getName() + " : onActivityPaused");
		}

		@Override
		public void onActivityStopped(Activity activity) {
			Log.i(TAG_ACTIVITY_LIFE, activity.getClass().getName() + " : onActivityStopped");
		}

		@Override
		public void onActivitySaveInstanceState(Activity activity,
				Bundle outState) {
			Log.i(TAG_ACTIVITY_LIFE, activity.getClass().getName() + " : onActivitySaveInstanceState");
		}

		@Override
		public void onActivityDestroyed(Activity activity) {
			Log.i(TAG_ACTIVITY_LIFE, activity.getClass().getName() + " : onActivityDestroyed");
		}
	}
	
}
