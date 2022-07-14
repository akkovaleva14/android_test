package com.sirius.test_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class ReviewAdapter(private val mReviews: List<ReviewModel>) :
    RecyclerView.Adapter<ReviewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userImage: AppCompatImageView = view.findViewById(R.id.userImage)
        val userName: AppCompatTextView = view.findViewById(R.id.userName)
        val date: AppCompatTextView = view.findViewById(R.id.date)
        val message: AppCompatTextView = view.findViewById(R.id.message)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_review, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val reviewModel: ReviewModel = mReviews.get(position)

        val userImage = viewHolder.userImage

        Glide
            .with(viewHolder.itemView.context)
            .load(reviewModel.userImage)
            .apply(RequestOptions.circleCropTransform())
            .into(viewHolder.userImage)

        val userName = viewHolder.userName
        userName.text = reviewModel.userName

        val date = viewHolder.date
        date.text = reviewModel.date

        val message = viewHolder.message
        message.text = reviewModel.message

    }


    override fun getItemCount() = mReviews.size
}
