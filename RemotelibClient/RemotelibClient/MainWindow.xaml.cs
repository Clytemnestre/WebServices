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

namespace RemotelibClient
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private static RemoteLibServiceReference.RemoteLibServiceSoapClient proxy;
        String filter = "";
        List<string> bookList;
        public MainWindow()
        {
            proxy = new RemoteLibServiceReference.RemoteLibServiceSoapClient();
            InitializeComponent();
            bookList = new List<string>();
            lvBookList.ItemsSource = bookList;
            RefreshListView();
        }

        private void btAddBook1_Click(object sender, RoutedEventArgs e)
        {
            String title = tbTitle.Text;
            String author = tbAuthor.Text;
            int yop;
            Int32.TryParse(tbYop.Text, out yop);
            proxy.AddBook(title, author, yop);
            RefreshListView();
        }

        private void RefreshListView()
        {
            bookList = proxy.GetFilteredBooks(filter);
            lvBookList.ItemsSource = bookList;
        }

        private void tbFilter_KeyUp(object sender, KeyEventArgs e)
        {
            filter = tbFilter.Text;
            RefreshListView();
        }
    }
}
