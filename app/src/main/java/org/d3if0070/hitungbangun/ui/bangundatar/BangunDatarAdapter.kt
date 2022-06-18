package org.d3if0070.hitungbangun.ui.bangundatar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3if0070.hitungbangun.BangunDatar
import org.d3if0070.hitungbangun.R
import org.d3if0070.hitungbangun.databinding.ListBangunDatarBinding
import org.d3if0070.hitungbangun.network.BangunDatarApi

class BangunDatarAdapter : RecyclerView.Adapter<BangunDatarAdapter.ViewHolder>() {

    private val data = mutableListOf<BangunDatar>()
    fun updateData(newData: List<BangunDatar>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: ListBangunDatarBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(bangunDatar: BangunDatar)= with(binding){
            namaTextView.text = bangunDatar.nama
            jumlahSudutTextView.text = bangunDatar.jumlahSudut
            rumusLuasTextView.text = bangunDatar.rumusLuas
            rumusKelilingTextView.text = bangunDatar.rumusKeliling
            Glide.with(imageView.context)
                .load(BangunDatarApi.getBangunDatarUrl(bangunDatar.imageId))
                .error(R.drawable.ic_baseline_broken_image_24)
                .into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =  ListBangunDatarBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}