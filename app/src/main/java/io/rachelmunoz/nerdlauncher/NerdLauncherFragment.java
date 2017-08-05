package io.rachelmunoz.nerdlauncher;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by rachelmunoz on 8/4/17.
 */

public class NerdLauncherFragment extends Fragment {
	private static final String TAG = "NerdLauncherFragment";

	private RecyclerView mRecyclerView;

	public static NerdLauncherFragment newInstance(){
		return new NerdLauncherFragment();
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_nerd_launcher, container, false);

		mRecyclerView = (RecyclerView) v.findViewById(R.id.app_recycler_view);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

		setupAdapter();
		return v;
	}

	private void setupAdapter(){
		Intent startupIntent = new Intent(Intent.ACTION_MAIN);
		startupIntent.addCategory(Intent.CATEGORY_LAUNCHER);

		PackageManager pm = getActivity().getPackageManager();
		List<ResolveInfo> activities = pm.queryIntentActivities(startupIntent, 0);

		Log.i(TAG, "Found " + activities.size() + " activities");

	}
}
