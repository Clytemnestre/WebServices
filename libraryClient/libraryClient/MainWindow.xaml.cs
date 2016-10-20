using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace libraryClient
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        static LibraryServiceReference.LibraryServiceSoapClient proxy;

        private void btnAddBook_Click(object sender, RoutedEventArgs e)
        {
            proxy = new LibraryServiceReference.LibraryServiceSoapClient();
            String title = tbName.Text;
            String author = tbAuthor.Text;
            String yopString = tbYear.Text;
            int yop = int.Parse(yopString);
            Console.WriteLine(title + author + yop);
            //proxy.AddBook(title, author, yop);
        }
    }
}
