import { useFormContext } from 'react-hook-form';

import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';
import Divider from '@mui/material/Divider';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';

import { useBoolean } from 'src/hooks/use-boolean';
import { useResponsive } from 'src/hooks/use-responsive';

import { useGetInvoice } from 'src/api/invoice';

import Iconify from 'src/components/iconify';

import { AddressListDialog } from '../address';

// ----------------------------------------------------------------------

type Props = {
  id: string;
};

export default function InvoiceNewEditAddress({ id }: Props) {

  const { invoice, invoiceLoading, invoiceError } = useGetInvoice(id);

  const fromAddressList = invoice?.invoiceFrom ? [invoice.invoiceFrom] : [];

  const toAddressList = invoice?.invoiceTo ? [invoice.invoiceTo] : [];

  const {
    watch,
    setValue,
    formState: { errors },
  } = useFormContext();

  const mdUp = useResponsive('up', 'md');

  const values = watch();

  const { invoiceFrom, invoiceTo } = values;

  const from = useBoolean();

  const to = useBoolean();

  if (invoiceLoading) {
    return <div>Loading...</div>;
  }

  if (invoiceError) {
    return <div>Error: {invoiceError.message}</div>;
  }

  if (!invoice) {
    return <div>No invoice found</div>;
  }

  return (
    <>
      <Stack
        spacing={{ xs: 3, md: 5 }}
        direction={{ xs: 'column', md: 'row' }}
        divider={
          <Divider
            flexItem
            orientation={mdUp ? 'vertical' : 'horizontal'}
            sx={{ borderStyle: 'dashed' }}
          />
        }
        sx={{ p: 3 }}
      >
        <Stack sx={{ width: 1 }}>
          <Stack direction="row" alignItems="center" sx={{ mb: 1 }}>
            <Typography variant="h6" sx={{ color: 'text.disabled', flexGrow: 1 }}>
              From:
            </Typography>

            <IconButton onClick={from.onTrue}>
              <Iconify icon="solar:pen-bold" />
            </IconButton>
          </Stack>

          <Stack spacing={1}>
            <Typography variant="subtitle2">{invoice.invoiceFrom.name}</Typography>
            <Typography variant="body2">{invoice.invoiceFrom.fullAddress}</Typography>
            <Typography variant="body2"> {invoice.invoiceFrom.phoneNumber}</Typography>
          </Stack>
        </Stack>

        <Stack sx={{ width: 1 }}>
          <Stack direction="row" alignItems="center" sx={{ mb: 1 }}>
            <Typography variant="h6" sx={{ color: 'text.disabled', flexGrow: 1 }}>
              To:
            </Typography>

            <IconButton onClick={to.onTrue}>
              <Iconify icon={invoiceTo ? 'solar:pen-bold' : 'mingcute:add-line'} />
            </IconButton>
          </Stack>

          {invoice.invoiceTo ? (
            <Stack spacing={1}>
              <Typography variant="subtitle2">{invoice.invoiceTo.name}</Typography>
              <Typography variant="body2">{invoice.invoiceTo.fullAddress}</Typography>
              <Typography variant="body2"> {invoice.invoiceTo.phoneNumber}</Typography>
            </Stack>
          ) : (
            <Typography typography="caption" sx={{ color: 'error.main' }}>
              {(errors.invoiceTo as any)?.message}
            </Typography>
          )}
        </Stack>
      </Stack>

      <AddressListDialog
        title="Customers"
        open={from.value}
        onClose={from.onFalse}
        selected={(selectedId: string) => invoiceFrom?.id === selectedId}
        onSelect={(address) => setValue('invoiceFrom', address)}
        list={fromAddressList}
        action={
          <Button
            size="small"
            startIcon={<Iconify icon="mingcute:add-line" />}
            sx={{ alignSelf: 'flex-end' }}
          >
            New
          </Button>
        }
      />

      <AddressListDialog
        title="Customers"
        open={to.value}
        onClose={to.onFalse}
        selected={(selectedId: string) => invoiceTo?.id === selectedId}
        onSelect={(address) => setValue('invoiceTo', address)}
        list={toAddressList}
        action={
          <Button
            size="small"
            startIcon={<Iconify icon="mingcute:add-line" />}
            sx={{ alignSelf: 'flex-end' }}
          >
            New
          </Button>
        }
      />
    </>
  );
}
