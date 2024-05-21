import Container from '@mui/material/Container';

import { paths } from 'src/routes/paths';

import { useGetInvoice } from 'src/api/invoice';

import { useSettingsContext } from 'src/components/settings';
import CustomBreadcrumbs from 'src/components/custom-breadcrumbs';

import InvoiceDetails from '../invoice-details';

// ----------------------------------------------------------------------

type Props = {
  id: string;
};

export default function InvoiceDetailsView({ id }: Props) {

  const { invoice, invoiceLoading } = useGetInvoice(id);

  const settings = useSettingsContext();

  if (invoiceLoading) {
    return <div>Loading...</div>;
  }


  return (
    <Container maxWidth={settings.themeStretch ? false : 'lg'}>
      <CustomBreadcrumbs
        heading={invoice?.invoiceNumber}
        links={[
          {
            name: 'Dashboard',
            href: paths.dashboard.root,
          },
          {
            name: 'Invoice',
            href: paths.dashboard.invoice.root,
          },
          { name: invoice?.invoiceNumber },
        ]}
        sx={{ mb: { xs: 3, md: 5 } }}
      />

      <InvoiceDetails invoice={invoice} />
    </Container>
  );
}
