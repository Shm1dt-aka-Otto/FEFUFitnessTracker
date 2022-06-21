package com.example.fefufitnesstracker.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fefufitnesstracker.ui.activity.TrackMyFragment
import com.example.fefufitnesstracker.ui.activity.TrackUsersFragment

class ViewPagerAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                TrackMyFragment()
            }
            1 -> {
                TrackUsersFragment()
            }
            else -> {
                Fragment()
            }
        }
    }

}