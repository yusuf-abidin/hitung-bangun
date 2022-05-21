package org.d3if0070.hitungbangun.ui.histori

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if0070.hitungbangun.R
import org.d3if0070.hitungbangun.databinding.ItemHistoriBinding
import org.d3if0070.hitungbangun.db.HitungEntity
import org.d3if0070.hitungbangun.model.hitungBangun
import java.text.SimpleDateFormat
import java.util.*

class HistoriAdapter :
    ListAdapter<HitungEntity, HistoriAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<HitungEntity>() {
                override fun areItemsTheSame(
                    oldItem: HitungEntity,
                    newItem: HitungEntity
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: HitungEntity,
                    newItem: HitungEntity
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoriBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

        class ViewHolder (
            private val binding:ItemHistoriBinding
        ):RecyclerView.ViewHolder(binding.root){

            private val dateFormatter = SimpleDateFormat("dd MMMM yyyy", Locale("id", "ID"))

            fun bind(item: HitungEntity) = with(binding) {
                val hasilHitung = item.hitungBangun()

                tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
                hitungTextView.text = root.context.getString(R.string.hasil_x, item.panjang, item.lebar)

                dataTextView.text = root.context.getString(R.string.data_x, hasilHitung.keliling, hasilHitung.luas)
            }
        }
    }
