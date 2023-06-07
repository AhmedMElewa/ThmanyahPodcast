package com.elewa.thmanyahpodcast.modules.playlist.presnetation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.elewa.thmanyahpodcast.core.extention.toDate
import com.elewa.thmanyahpodcast.core.extention.toFormattedString
import com.elewa.thmanyahpodcast.databinding.ItemMediaBinding
import com.elewa.thmanyahpodcast.modules.playlist.domain.entity.EpisodeEntity
import javax.inject.Inject

class PlayListAdapter @Inject constructor() :
    ListAdapter<EpisodeEntity, PlayListAdapter.MyViewHolder>(MyDiffUtil) {

    companion object MyDiffUtil : DiffUtil.ItemCallback<EpisodeEntity>() {
        override fun areItemsTheSame(oldItem: EpisodeEntity, newItem: EpisodeEntity): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: EpisodeEntity, newItem: EpisodeEntity): Boolean {
            return oldItem.id == newItem.id
        }
    }

    inner class MyViewHolder(private val binding: ItemMediaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: EpisodeEntity?) {
            item?.let {
                Glide.with(binding.imgMedia)
                    .load(item.image)
                    .into(binding.imgMedia)
                binding.txtMediaHeader.text = item.name
                binding.txtMediaOwner.text = item.podcastName
                binding.txtMediaDate.text = "${item.releaseDate.toDate()?.toFormattedString()} . ${item.durationInSeconds/60} دقيقة"

            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemMediaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener {
//            onClickListener.onClick(item)
        }
        holder.bind(item)
    }

    class OnClickListener(val clickListener: (item: EpisodeEntity) -> Unit) {
        fun onClick(item: EpisodeEntity) = clickListener(item)
    }
}