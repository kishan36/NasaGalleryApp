package com.app.nasagalleryapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.nasagalleryapp.databinding.RowImageGridBinding
import com.app.nasagalleryapp.models.DataModel
import com.bumptech.glide.Glide

class RVImageListingViewHolder(val binding: RowImageGridBinding) :
    RecyclerView.ViewHolder(binding.root)

class RVImageListingAdapter(
    private val images: List<DataModel>,
    private val onTap: (Int) -> Unit
) :
    RecyclerView.Adapter<RVImageListingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVImageListingViewHolder {
        val binding =
            RowImageGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RVImageListingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RVImageListingViewHolder, position: Int) {
        Glide.with(holder.itemView).load(images[position].url).centerCrop()
            .into(holder.binding.image)
        holder.binding.root.setOnClickListener {
            onTap.invoke(position)
        }
    }

    override fun getItemCount(): Int = images.size
}