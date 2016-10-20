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
using CookComputing.XmlRpc;

namespace WpfApplication1
{
    [XmlRpcUrl("http://127.0.0.1:8282/XmlRpcServlet")]
    public interface ILibrary : IXmlRpcProxy
    {
        [XmlRpcMethod("Remotelibrary.addBook")]
        int AddBook(String title, String author, int yop);
        //public ArrayList<String> getAllBooks() throws IOException;
    }
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        ILibrary proxy;
        public MainWindow()
        {
            InitializeComponent();
            ILibrary proxy = XmlRpcProxyGen.Create<ILibrary>();
        }

        private void button_click(object sender, RoutedEventArgs e)
        {            
            proxy.AddBook("Csharp", "C. Sharp", 2000);
        }
    }
}
