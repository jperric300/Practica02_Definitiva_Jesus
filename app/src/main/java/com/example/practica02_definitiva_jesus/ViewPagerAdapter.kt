import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.practica02_definitiva_jesus.StudentFragment


class ViewPagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa){

    companion object{
        private const val ARG_OBJECT = "object"
    }

    override  fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        val fragment = StudentFragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, position)
        }
        return  fragment
    }
}