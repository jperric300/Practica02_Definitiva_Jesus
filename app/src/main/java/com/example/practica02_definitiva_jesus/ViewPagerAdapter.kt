import android.os.Bundle
import android.provider.Settings.Global.putInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.practica02_definitiva_jesus.Data.Student
import com.example.practica02_definitiva_jesus.DemoObjectFragment


class ViewPagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa){

    companion object{
        private const val ARG_OBJECT = "object"
    }

    override  fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        val fragment = DemoObjectFragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, position)

        }
        return  fragment
    }

}