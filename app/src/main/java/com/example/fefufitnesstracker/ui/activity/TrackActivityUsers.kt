package com.example.fefufitnesstracker.ui.activity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.fragment.findNavController
import com.example.fefufitnesstracker.R
import com.example.fefufitnesstracker.data.CardsData
import com.example.fefufitnesstracker.domain.entity.CardType
import com.example.fefufitnesstracker.ui.adapter.RecyclerViewAdapter


class TrackUsersFragment : Fragment(R.layout.fragment_activity_users) {

    private val activityData = CardsData()

    private val adapter = RecyclerViewAdapter {
        val information =
            TrackFragmentDirections.actionTrackFragmentToTrackDetailsFragment(
                it.distance,
                it.period,
                it.typeActivity,
                it.dateActivity,
                it.cardType,
                it.nickname
            )

        findNavController().navigate(information)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<RecyclerView>(R.id.usersCards).apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@TrackUsersFragment.adapter
        }
        adapter.setData(activityData.getDefaultData(CardType.USERS))
    }

}